(ns jaretbinford.day3
  (:require [clojure.string :as s]))

;Power consumption (p-consum)
;g-rate
;e-rate
;p-consum = g-rate * e-rate
; input binary, most common bit in corresponding position is g-rate, final g-rate is 5 bits. a binary which can be converted to decimal
; input binary, least common bit in corresponding position is e-rate, 5 bits, converted to decimal.
; final answer in decimal.

;frequencies might be useful
;to-decimal for conversion?

(defn parsed-input [puzzle-input]
  (->> (slurp puzzle-input)
       (s/split-lines)
       (map (fn [s]
              (->> (seq s)
                   (map #(- (int %) (int \0))))))))

;Learn to use re-seq to parse logs and to do the above faster.
(re-seq #"\d" "10101010101010101010101010103312312")

(comment
  (parsed-input "resources/day3input.edn"))

(defn most-common
  [xs n]
  (let [freqs (->> xs
                   (map #(nth % n))
                   frequencies)]
    (if (> (get freqs 1)
           (get freqs 0))
      1
      0)))


;binary math, specifically bit-xor allows me to find least common from most common
(def power-consumption
  (let
    [g-rate
     (Integer/parseInt
       (apply str
              (for [n (range 12)]
                (-> "resources/day3input.edn"
                    parsed-input
                    (most-common n)))) 2)
     e-rate
     (bit-xor g-rate 2r111111111111)]
    (* g-rate e-rate)))


(comment
  (-> "resources/day3input.edn"
      parsed-input
      (most-common 0)))




