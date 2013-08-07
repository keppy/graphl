(defproject signal-station "0.1.0-SNAPSHOT"
  :description "Web services for the graphl project"
  :url "http://graphlings.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring/ring-core "1.2.0"]
                 [ring/ring-jetty-adapter "1.2.0"]
                 [compojure "1.1.5"]
                 [lein-ring "0.8.6"]]
  :ring { :handler signal-station.core/handler})
