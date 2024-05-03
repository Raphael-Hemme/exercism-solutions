(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn kebab-to-camel-case
  [s]
  (->> (str/split s #"-") 
      (map-indexed #(if (> %1 0) (str/capitalize %2) %2))
      (apply str)))

(defn replace-non-letters
  [s]
  (str/replace s #"/[^\p{L}\-]/gu" ""))

(defn clean
  "TODO: add docstring"
  [s]
  (-> s
      (str/replace " " "_")
      (str/replace #"\p{Cc}" "CTRL")
      (kebab-to-camel-case)
      (str/replace #"[^\p{L}\p{M}\-\_]" "")))


;; Test cases

(clean "my   Id")
(clean "my   Id  ")
(clean "my\u007FId")
(clean "nice-test-case")
(clean "1😀2😀3😀")
(clean "nice_test-case")