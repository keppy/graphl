(ns signal-station.remotes
  (:require [signal-station.core :refer [handler]]
            [compojure.handler :refer [site]]
            [shoreleave.middleware.rpc :refer [defremote wrap-rpc]]
            [clojurewerkz.titanium.graph :refer [transact! open]]
            [clojurewerkz.titanium.vertices :as tv]
            [ogre.core :as oq])
  (:import java.io.File))

(open (System/getProperty "java.io.tmpdir"))

(defn get-email [email]
  (transact! 
    (oq/query (tv/find-by-kv :email email)
              (oq/property :email)
              oq/first-of!)))

(defn create-email! [email]
  (transact!
   (tv/create! {:email email}))
  "We've added you to the graph. We will let you know when your beta account is ready and help you get started.")

(defremote beta-signup [email]
  (cond
   (= email (get-email email)) "Yo, you're already in the graph."
   :else  (create-email! email)))

(def app (-> (var handler)
             (wrap-rpc)
             (site)))
