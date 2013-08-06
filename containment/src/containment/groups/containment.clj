(ns containment.groups.containment
    "Node defintions for containment"
  (:use 
    pallet.compute :only [compute-service]))

(def titan-data-center
  (compute-service
    "node-list"
    :node-list [["titan1" "fullstack" "999999" :ubuntu]]))
