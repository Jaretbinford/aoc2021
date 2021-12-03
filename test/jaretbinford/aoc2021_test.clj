(ns jaretbinford.aoc2021-test
  (:require [clojure.test :refer :all]
            [jaretbinford.day3  :refer :all]))

(deftest common-stress
  (testing "to see if other input works for most-common function"
    (is (= 0 (-> "resources/day3input.edn"
                 parsed-input
                 most-common)))))

(deftest common-stress2
  (testing "to see if other input works for most-common function"
    (is (= 1 (-> "resources/manualtest1.edn"
                 parsed-input
                 most-common)))))

(deftest common-stress3
  (testing "to see if other input works for most-common function"
    (is (= 0 (-> "resources/manualtest0.edn"
                 parsed-input
                 most-common)))))
