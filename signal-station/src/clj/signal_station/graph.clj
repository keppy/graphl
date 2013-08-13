(ns signal-station.graph
  (:require [clojurewerkz.titanium.graph :as tg]))

(defn- main
  [& args]
  ;; opens a BerkeleyDB-backed graph database in a temporary directory
  (tg/open (System/getProperty "java.io.tmpdir"))
  "Graph business goes here")
(main))
