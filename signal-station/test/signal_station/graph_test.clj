(ns signal-station.graph-test
  (:require [clojure.test :refer :all]
            [signal-station.graph :refer :all]))

(deftest table-select-test
  (testing "Alex is in the db"
    (is (= (select "users") [{:email "alex@gmail.com"}]))))
