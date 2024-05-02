(ns squeaky-clean
  (:require [clojure.string :as str]))

;; (defn replaceControlChar
;;   [c] 
;;   ((if (Character/isISOControl c) "CTRL" c)))

(defn replaceControlChar
  [c]
  ((if (Character/isISOControl c) "CTRL" c)))

(defn clean
  "TODO: add docstring"
  [s]
  (-> s
      (str/replace " " "_")
      (str/replace #"\p{Cc}" "CTRL")))



(clean "my   Id")
(clean "my   Id  ")


(clean "my\u007FId")