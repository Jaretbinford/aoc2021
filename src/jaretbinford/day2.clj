(ns jaretbinford.day2
  (:require [clojure.string :as s]))

(def puzzle-input "resources/day2input.edn")


(def parsed-input
  (->> (slurp puzzle-input)
       (clojure.string/split-lines)
       (map #(clojure.string/split % #" "))
       (map (fn [[direction value]]
              [(keyword direction) (Integer/parseInt value)]))))

(comment
  parsed-input)

(defn part-1
  [all-instructions]
  (loop [x 0
         y 0
         instructions all-instructions]
    (if (empty? instructions)
      (* x y)
      (let [[k v] (first instructions)
            dx (if (= k :forward) v 0)
            dy (if (= k :down) v (if (= k :up) (- v) 0))]
        (recur (+ x dx) (+ y dy) (rest instructions))))))

(comment
  (part-1 parsed-input)
  ;1654760
  )







