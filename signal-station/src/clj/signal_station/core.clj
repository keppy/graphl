(ns signal-station.core
  (:use compojure.core 
        [ring.adapter.jetty :only [run-jetty]])
  (:require [compojure.core :refer [defroutes GET]]
            [compojure.route :refer [resources not-found]]
            [compojure.handler :refer [site]]
            [signal-station.graph]))

(defroutes main-routes
    (GET "/" [] "<p>Hello from graphsockets</p>" )
    (resources "/")
    (not-found "Page not found"))
