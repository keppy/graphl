(ns signal-station.remotes
  (:require [signal-station.core :refer [handler]]
            [compojure.handler :refer [site]]
            [shoreleave.middleware.rpc :refer [defremote wrap-rpc]]
            [clojurewerkz.titanium.graph :refer [transact! open]]
            [clojurewerkz.titanium.vertices :as tv]))

(defn get-email [email]
  (transact!
   (get
    (tv/find-by-kv :email email)
    :email)))

(defn create-email! [email]
  (transact!
   (tv/create! {:email email})))

(defremote beta-signup [email]
  (open (System/getProperty "java.io.tmpdir"))
  (cond
   (= email (get-email email) "Yo, you're already in the graph.")
   :else  (create-email!) "We've added you to the graph. We will let you know when your beta account is ready and help you get started."))

(def app (-> (var handler)
             (wrap-rpc)
             (site)))
