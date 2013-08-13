(ns signal-station.remotes
  (:require [signal-station.core :refer [handler]]
            [signal-station.graph :as [graph]]
            [compojure.handler :refer [site]]
            [shoreleave.middleware.rpc :refer [defremote wrap-rpc]]
            [clojurewerkz.titanium.graph :as [tg]]
            [clojurewerkz.titanium.vertices :as [tv]]))
  
(tg/open (System/getProperty "java.io.tmpdir"))

(defremote beta-signup [email]
  (tg/transact! 
    (let [entry (tv/find-by-kv :email email)]
      (cond
        (= email entry) "Yo, you're already in the graph."
        :else  (tv.create! {:email email}) "You're in the graph now, we'll keep you posted on the beta!"))))

(def app (-> (var handler)
             (wrap-rpc)
             (site)))
