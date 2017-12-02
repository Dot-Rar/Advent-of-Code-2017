(ns Day2
  (:require [clojure.string :as str]))

(defn solve [spreadsheet]
  (def result 0)
  (def rows (str/split-lines spreadsheet))
  (doseq [row rows]
    (def chars (filter #{\1, \2, \3, \4, \5, \6, \7, \8, \9, \0} (seq row)))
    (doseq [char chars]
      (def i (- (int char) 48))
      (doseq [char1 chars]
        (def j (- (int char1) 48))
        (if (and (integer? (/ i j)) (not (= (/ i j) 1)))
          (def result (+ result (/ i j)))
          )
        )
      )
    )
  (println result)
  )

(defn -main
  [] (solve "5 9 2 8
9 4 7 3
3 8 6 5"))
