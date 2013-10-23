(ns signal-station.core
  (:require [ring.adapter.jetty :only [run-jetty]]
            [ring.util.response :as resp]
            [compojure.core :refer [defroutes GET POST]]
            [compojure.route :refer [resources not-found]]
            [compojure.handler :refer [site]]))

(defroutes main-routes
    (GET "/" []
         (resp/redirect "/simple.html"))
    (resources "/")
    (not-found "Page not found"))

(def handler
  (site main-routes))
