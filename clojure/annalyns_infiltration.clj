;; https://exercism.org/tracks/clojure/exercises/annalyns-infiltration

(ns annalyns-infiltration)

(defn can-fast-attack?
  "Returns true if a fast-attack can be made, false otherwise."
  [knight-awake?]
  (not knight-awake?))

(defn can-spy?
  "Returns true if the kidnappers can be spied upon, false otherwise."
  [knight-awake? archer-awake? prisoner-awake?]
  (or knight-awake? archer-awake? prisoner-awake?))


(defn can-signal-prisoner?
  "Returns true if the prisoner can be signalled, false otherwise."
  [archer-awake? prisoner-awake?]
  (and (not archer-awake?) prisoner-awake?))

;; (defn can-free-prisoner?
;;   "Returns true if prisoner can be freed, false otherwise."
;;   [knight-awake? archer-awake? prisoner-awake? dog-present?]
;;   (if dog-present?
;;     (not archer-awake?)
;;     (and prisoner-awake? (not archer-awake?) (not knight-awake?))))

;; Just playing around with some core functions. The above solution is easier to read.
(defn can-free-prisoner?
  "Returns true if prisoner can be freed, false otherwise."
  [knight-awake? archer-awake? prisoner-awake? dog-present?]
  (if dog-present?
    (not archer-awake?)
    (eval (cons 'and (cons prisoner-awake? (map not [archer-awake? knight-awake?]))))))


;; Checking funcitonality:
(def knight-awake? false)
(def archer-awake? true)
(def prisoner-awake? false)
(def dog-present? false)

(can-spy? knight-awake? archer-awake? prisoner-awake?)
(can-signal-prisoner? archer-awake? prisoner-awake?)
(can-fast-attack? knight-awake?)
(can-free-prisoner? knight-awake? archer-awake? prisoner-awake? dog-present?)