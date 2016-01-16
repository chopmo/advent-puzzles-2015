(ns cljpuzzles.day6
  (:require [clojure.string :as s]))

(defn toggle
  [grid pos]
  (assoc ))

(defn read-input-lines
  []
  (s/split-lines (slurp "input/day6.txt")))

; Example instruction: "turn off 464,858 through 833,915"
(defn parse-instruction
  [s]
  (let [[_ cmd sx1 sy1 sx2 sy2] (re-matches #"(turn off|turn on|toggle) (\d{1,3}),(\d{1,3}) through (\d{1,3}),(\d{1,3})" s)]
    [cmd
     (Integer. sx1)
     (Integer. sy1)
     (Integer. sx2)
     (Integer. sy2)]))

(def operations
  { "toggle" not
    "turn on" (constantly true)
    "turn off" (constantly false)})

(defn apply-instruction
  [grid instruction]
  (let [[cmd x1 y1 x2 y2] (parse-instruction instruction)
        positions (for [y (range y1 (inc y2))
                        x (range x1 (inc x2))]
                    [x,y])
        operation (get operations cmd)
        f (fn [grid pos] (assoc grid pos (operation (get grid pos))))]
    (reduce f grid positions)))

(defn solve
  []
  (let [input-lines (read-input-lines)
        grid (reduce apply-instruction {} input-lines)]
    (count (filter identity (vals grid)))))
