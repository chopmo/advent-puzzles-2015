(ns cljpuzzles.core
  (:require [clojure.string :as s]))

(defn day5-1
  []
  (let [strings (s/split-lines (slurp "input/day5.txt"))
        nice? (fn [s]
                (and
                 (>= (count (re-seq #"[aeiou]" s)) 3)
                 (re-seq #"(.)\1" s)
                 (not (re-seq #"ab|cd|pq|xy" s))))]
    (count (filter nice? strings))))

(defn day5-2
  []
  (let [strings (s/split-lines (slurp "input/day5.txt"))
        nice? (fn [s]
                (and
                 (re-seq #"(..).*\1" s)
                 (re-seq #"(.).\1" s)))]
    (count (filter nice? strings))))
