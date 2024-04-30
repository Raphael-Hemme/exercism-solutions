(ns log-levels
  (:require [clojure.string :as str]))

(defn message
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (str/trim (str/replace s #"\[(.*?)\]:" "")))

(defn message2
  "Takes a string representing a log line
   and returns its message with whitespace trimmed."
  [s]
  (-> (str/replace s #"\[(.*?)\]:" "")
      (str/trim)))

(defn log-level
  "Takes a string representing a log line
   and returns its level in lower-case."
  [s]
  (-> (str/split s #"]")
      (first)
      (str/replace ,,, "[" "")
      (str/lower-case ,,,)))

(defn reformat
  "Takes a string representing a log line and formats it
   with the message first and the log level in parentheses."
  [s])



(message "[ERROR]: Invalid operation")
(message "[WARNING]:  Disk almost full\r\n")

(message2 "[ERROR]: Invalid operation")
(message "[WARNING]:  Disk almost full\r\n")

(log-level "[WARNING]:  Disk almost full\r\n")