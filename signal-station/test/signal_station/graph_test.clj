(ns signal-station.graph-test
  (:require [clojure.test :refer :all]
            [signal-station.graph :refer :all]
            [clojurewerkz.cassaforte.client :as client])
  (:use clojurewerkz.cassaforte.cql
        clojurewerkz.cassaforte.query))

(deftest table-select-test
  (testing "Alex is in the db"
    (is (= (select "users") [{:email "alex@gmail.com"}]))))
