(ns squeaky-clean
  (:require [clojure.string :as str]))

;; (defn replaceControlChar
;;   [c] 
;;   ((if (Character/isISOControl c) "CTRL" c)))

(defn kebab-to-camel-case
  [s]
  (apply str (map-indexed (fn [idx itm] 
                 (if (> idx 0) (str/capitalize itm) itm))
               (str/split s #"-"))))

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