;; https://exercism.org/tracks/clojure/exercises/interest-is-interesting

(ns interest-is-interesting)

(defn decimal-percent
  [percentage]
  (bigdec (/ percentage 100M)))

(defn interest-rate
  "Returns the interest rate based on the specified balance."
  [balance]
  (cond (< balance 0) -3.213
        (< balance 1000) 0.5
        (< balance 5000) 1.621
        :else 2.475))

(interest-rate 200.75M)

(defn interest
  [balance]
  (* (abs balance) (decimal-percent (interest-rate balance))))

(defn annual-balance-update
  "Returns the annual balance update, taking into account the interest rate."
  [balance]
  (+ balance (interest balance)))

(annual-balance-update 200.75M)

(defn amount-to-donate
  "Returns how much money to donate based on the balance and the tax-free percentage."
  [balance tax-free-percentage] 
  (cond (>= balance 0) (int (* balance (decimal-percent tax-free-percentage) 2)) 
        :else 0))

(def balance 550.5M)
(def tax-free-percentage 2.5)

(amount-to-donate balance tax-free-percentage)
(annual-balance-update 1000.0001M)
