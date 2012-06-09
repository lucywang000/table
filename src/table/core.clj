(ns table.core
  (:use [clojure.string :only [join]] ))

(defn render [table]
  (let [spacer
         (str "+-"
           (join "-+-"
             (map #(apply str (repeat (.length %) "-"))
               (first table)))
                    "-+")]
    (concat [spacer
             (str "| " (join " | " (first table)) " |")
             spacer]
            (for [tr (rest table)]
              (str "| " (join " | " tr) " |"))
            [spacer])))

(defn table-str [& args]
  (apply str (join "\n" (apply render args))))

(defn table [& args]
  (print (apply table-str args)))

