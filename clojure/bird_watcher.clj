(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today
  [birds]
  (last birds))

(defn inc-bird
  [birds]
  (assoc birds 6 (inc (today birds))))

(inc-bird last-week)

(defn day-without-birds?
  [birds]
  (if (nil? (some #(= 0 %) birds)) false true))

(day-without-birds? last-week)

(defn n-days-count
  [birds n]
  (cond (>= n (count birds)) (reduce + birds)
        :else (reduce + (subvec birds 0 n))))

(n-days-count [1 1 1 1 1 1 1] 5)

(defn busy-days
  [birds]
  (count (filter #(>= % 5) birds)))

(busy-days last)