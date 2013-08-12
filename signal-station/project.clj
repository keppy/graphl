(defproject signal-station "0.1.0-SNAPSHOT"
  :description "Web services for the graphl project"
  :url "http://graphlings.com"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [ring/ring-core "1.2.0"]
                 [ring/ring-jetty-adapter "1.2.0"]
                 [compojure "1.1.5"]
                 [shoreleave/shoreleave-remote-ring "0.3.0"]
                 [shoreleave/shoreleave-remote "0.3.0"]
                 [prismatic/dommy "0.1.1"]
                 [clojurewerkz/cassaforte "1.1.0"]
                 [org.clojure/tools.nrepl "0.2.3"]]
  :ring {:handler signal-station.remotes/app}

  :plugins [[lein-cljsbuild "0.3.2"]
            [lein-ring "0.8.6"]]

  ;; cljsbuild options configuration
  :cljsbuild {:builds
              [{;; CLJS source code path
                :source-paths ["src/cljs"]

                ;; Google Closure (CLS) options configuration
                :compiler {;; CLS generated JS script filename
                           :output-to "resources/public/js/signal-station.js"

                           ;; minimal JS optimization directive
                           :optimizations :whitespace

                           ;; generated JS code prettyfication
                           :pretty-print true}}]})
