(ns cars-assemble)

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (* (* 221 speed) (cond (== speed 10) 0.77
                         (== speed 9) 0.8
                         (> speed 4) 0.9
                         (>= speed 1) 1.0
                         :else 0.0)))

(production-rate 6)

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (int (/ (production-rate speed) 60)))

(working-items 6)