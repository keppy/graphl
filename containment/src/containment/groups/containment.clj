(ns containment.groups.containment
    "Node defintions for containment"
  (:use 
    [pallet.compute :only [compute-service]]
    [pallet.action.exec-script :only [exec-script]]
    [pallet.phase :only [phase-fn]]
    [pallet.core :only [group-spec lift]]))

(def titan-data-center
  (compute-service
    "node-list"
    :node-list [["NAME" "fullstack" "IP" :ubuntu]]))

(defn test-containment
  (lift
    (group-spec
      "fullstack"
       :phases { :configure (phase-fn
                             (exec-script (ls)))}
       :compute titan-data-center)))

(defn install-apache2
  (lift
    (group-spec
      "fullstack"
      :phases { :configure (phase-fn
                            (exec-script (sudo apt-get install apache2)))})))
