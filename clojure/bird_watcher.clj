;; https://exercism.org/tracks/clojure/exercises/bird-watcher

(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today
  [birds]
  (last birds))

(defn inc-bird
  [birds]
  (conj (pop birds) (inc (today birds))))

(inc-bird last-week)

(defn day-without-birds?
  [birds]
  (or (some zero? birds) 
      false))

(day-without-birds? last-week)

(defn n-days-count
  [birds n]
  (reduce + (take n birds)))

(n-days-count [1 1 1 1 1 1 1] 5)

(defn busy-days
  [birds]
  (count (filter #(>= % 5) birds)))

(busy-days last-week)

(defn odd-week? 
  [birds]
  (or (= birds [1 0 1 0 1 0 1]) (= birds [0 1 0 1 0 1 0])))

(odd-week? [0 1 0 1 0 1 1])