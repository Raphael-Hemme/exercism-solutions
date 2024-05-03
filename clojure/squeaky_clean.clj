(ns squeaky-clean
  (:require [clojure.string :as str]))

(defn kebab-to-camel-case
  [s]
  (->> (str/split s #"-") 
      (map-indexed #(if (> %1 0) (str/capitalize %2) %2))
      (apply str)))

(defn clean
  "TODO: add docstring"
  [s]
  (-> s
      (str/replace " " "_")
      (str/replace #"\p{Cc}" "CTRL")
      (kebab-to-camel-case ,,,)))



(clean "my   Id")
(clean "my   Id  ")


(clean "my\u007FId")
  
(clean "nice-test-case")