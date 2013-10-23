(ns signal-station.remotes
  (:require [signal-station.core :refer [handler]]
            [compojure.handler :refer [site]]
            [shoreleave.middleware.rpc :refer [defremote wrap-rpc]]))

(defremote beta-signup [email]
  email)

(def app (-> (var handler)
             (wrap-rpc)
             (site)))
