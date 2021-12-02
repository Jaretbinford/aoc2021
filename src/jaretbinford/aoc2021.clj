(ns jaretbinford.aoc2021
  (:require [clojure.string :as s]))
;NA
;Increased
;Decreased

(defn parse-input [puzzle-input]
  (map #(Integer. %) (s/split-lines (slurp puzzle-input))))

(defn count-increase [input]
  (count (filter #(> (second %) (first %)) (partition 2 1 input))))

(count-increase (parse-input "resources/day1input.edn"))

(defn count-sum
  [input]
  (count-increase (map #(reduce + %) (partition 3 1 input))))

(count-sum (parse-input "resources/day1input.edn"))

;;REPL Output
(comment
  jaretbinford.aoc2021=> (ns jaretbinford.aoc2021
                           (:require [clojure.string :as s]))
  nil
  jaretbinford.aoc2021=> (defn parse-input [puzzle-input]
                           (map #(Integer. %) (s/split-lines (slurp puzzle-input))))
  #'jaretbinford.aoc2021/parse-input
  jaretbinford.aoc2021=> (defn count-increase [input]
                           (count (filter #(> (second %) (first %)) (partition 2 1 input))))
  #'jaretbinford.aoc2021/count-increase
  jaretbinford.aoc2021=> (count-increase (parse-input "resources/day1input.edn"))
  1292
  jaretbinford.aoc2021=> (defn count-sum
                           [input]
                           (count-increase (map #(reduce + %) (partition 3 1 input))))
  #'jaretbinford.aoc2021/count-sum
  jaretbinford.aoc2021=> (count-sum (parse-input "resources/day1input.edn"))
  1262)



