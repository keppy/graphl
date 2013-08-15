(ns signal-station.core
  (:require [ring.adapter.jetty :only [run-jetty]]
            [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [resources not-found]]
            [compojure.handler :refer [site]]))

(defroutes main-routes
    (GET "/" [] "<p>Hello from graphsockets</p>")
    (resources "/")
    (not-found "Page not found"))

(def handler
  (site main-routes))
