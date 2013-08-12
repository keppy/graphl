(ns signal-station.graph
  (:require [clojurewerkz.cassaforte.client :as client])
  (:use clojurewerkz.cassaforte.cql
        clojurewerkz.cassaforte.query))

(defn bootstrap [keyspace table]
  (client/connect! ["127.0.0.1"])
  (create-keyspace keyspace)
  (use-keyspace keyspace)

  (create-table table
                (column-definitions {:email :varchar
                                     :primary-key [:email]})))

(defn add-user [email table]
  (client/prepared
   (insert table {:email email})))
