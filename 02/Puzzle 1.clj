(ns Day2
  (:require [clojure.string :as str]))

(defn solve [spreadsheet]
  (def result 0)
  (def rows (str/split-lines spreadsheet))
  (doseq [row rows]
    (def chars (filter #{\1, \2, \3, \4, \5, \6, \7, \8, \9, \0} (seq row)))
    (def max 0)
    (def min 10)
    (doseq [char chars]
      (def i (- (int char) 48))
      (if (> i max)
        (def max i)
        )
      (if (< i min)
        (def min i)
        ))
    (def result (+ result (- max min))))
    (println result)
  )

(defn -main
  [] (solve "5 1 9 5
7 5 3
2 4 6 8"))
