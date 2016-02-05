(ns clojure-startup.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World nigga sss(!"))

(println "HELLO NIGGA")


(if true 
  "By zeus hammer"
  "By aqua trident"
)

(if false
  "by zeus"
  "by aqua"
)

(if true
  (do (println "hello")
      "zeus hammer")
  (do (println "falseyyyy")
      "aqua hammer")
)

(when true
  (println "Success")
  "abra cadabra")

(= 1 1)

(def failed-protagonist-names ["Larry " "doreen" "Bulk"])

(defn error-message
  [severity]
  (str "OH GOD ITS A DIASTER " 
       (if (= severity :mild)
         "Mildy"
         "DOOMED")))

(error-message :mild)

{:first-name "Charlie"
:last-name "McFishwich"}

{:name {:first "John" :middle "Jacob" :last "Jingleheimerschmidt"}}

{"string-key" +}

(get (hash-map :a 1 :b 2) :b)

(get-in {:a 0 :b {:c "hoho"}}  [:b :c])

({:name "the nigga skoglund"} :name)

(:d {:a 1 :b 2 :c 3} "DEFAULT VALUE")

(get [3 2 1] 1)

(get ["a" {:name "pugsy"} "c"] 1)

(vector "creepy" "full" "moon")

(conj [1 2 3] 4)

'(1 2 3 4)

(nth '(:a :b :c) 0)

(list 1 "two" {3 4})

;; When should you use a list and when should you use a vector? A good rule of thumb is that if you need to easily add items to the beginning of a sequence or if you’re writing a macro, you should use a list. Otherwise, you should use a vector
(conj '(1 2 3) 4)

#{"Kurt" :iciilel 20}

(hash-set 1 1 2 2)

(conj #{:a :b} :b)

(set [3 3 3 4 4])

(contains? #{:a :b} :a)

(contains? #{:a :b} 3)

(contains? #{nil} nil)

(:a #{:a :b})

(get  #{2 :b} 2)

(+ 1 2 3 4)

(first [1 2 3 4])

((or + -) 1 2 3)

((and (= 1 1) +) 1 2 3)

((first [+ 0]) 1 2 3)

(inc 1.1)

(map inc [0 1 2 3])

(+ (inc 199) (/ 100 (- 7 2)))
(+ 200 (/ 100 (- 7 2))) ; evaluated "(inc 199)"
(+ 200 (/ 100 5)) ; evaluated (- 7 2)
(+ 200 20) ; evaluated (/ 100 5)
;220 ; final evaluation


(defn tooenthuastic
  "Return a cheer that might be a bit to enthastic"
  [name]
  (str "Oh my gaaad" name " you are beast " "heheheheh"))

(tooenthuastic "SKO")

(doc map)

(defn multi-arity
  ;; 3-arity arguments and body
  ([first-arg second-arg third-arg]
     (println first-arg second-arg third-arg))
  ;; 2-arity arguments and body
  ([first-arg second-arg]
     (println first-arg second-arg))
  ;; 1-arity arguments and body
  ([first-arg]
     (println first-arg)))

(multi-arity "to")

(defn x-chop
  "Describe the kind of chop you're inflicting on someone"
  ([name chop-type]
     (str "I " chop-type " chop " name "! Take that!"))
  ([name]
     (x-chop name "karate")))

(x-chop "kennet")


(defn codger-communication
  [whippersnapper]
  (str "get off nigga" whippersnapper " !!!!!"))

(defn codger 
  [& whippernsappers]
  (map codger-communication whippernsappers))

(codger " kooko", "kokookoaowowaoao", "232323")

;; Things er resten.
(defn favorite-things
  [name & things]
  (str "Hi, " name ", here are my favorite things: "
       (clojure.string/join ", " things)))

(favorite-things "Doreen" "gum" "shoes" "kara-te")


(defn my-first
  [[first-thing second-thing]]
  (println second-thing)
  first-thing)

(my-first ["oven" "bike" "war-axe"])

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))

(chooser ["Marmalade", "Handsome Jack", "Pigpen", "Aquaman"])

(defn announce-treasure-location
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure-location {:lat 28.22 :lng 81.33})


(defn announce-treasure
  [{:keys [lat lng]}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure {:lng 2323 :lat 233})

(defn illustrative-function
  []
  (+ 1 304)
  30
  "joe")

(illustrative-function)

(defn number-comment
  [x]
  (if (> x 6)
    "Oh my gosh! What a big number!"
    "That number's OK, I guess"))

(number-comment 5)

(number-comment 7)

(map (fn [name] (str "hi, " name)) ["HHOHOHO" "JOOJO"])

((fn [x] (* x 3)) 8)


(def my-special-multiplier (fn [x] (* x 3)))
(my-special-multiplier 12)

(#(* % 3) 8)

(#(str %1 " and " %2) "cornbread" "butter beans")

(#(identity %&) 1 "blarg" :yip)

(defn inc-maker
  "Create a custom incrementor"
  [inc-by]
  #(+ % inc-by))

(def inc3 (inc-maker 3))

(inc3 7)


(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}
                             {:name "left-ear" :size 1}
                             {:name "mouth" :size 1}
                             {:name "nose" :size 1}
                             {:name "neck" :size 2}
                             {:name "left-shoulder" :size 3}
                             {:name "left-upper-arm" :size 3}
                             {:name "chest" :size 10}
                             {:name "back" :size 10}
                             {:name "left-forearm" :size 3}
                             {:name "abdomen" :size 6}
                             {:name "left-kidney" :size 1}
                             {:name "left-hand" :size 2}
                             {:name "left-knee" :size 2}
                             {:name "left-thigh" :size 4}
                             {:name "left-lower-leg" :size 3}
                             {:name "left-achilles" :size 1}
                             {:name "left-foot" :size 2}])

(defn matching-part
  "matching"
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-")
   :size (:size part)})

(defn symmetrize-body-parts
  "Expects a seq of  maps that have a :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts final-body-parts []]
    (if (empty? remaining-asym-parts)
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(symmetrize-body-parts asym-hobbit-body-parts)


(loop [iteration 0]
  (println (str "Iteration " iteration))
  (if (> iteration 3)
    (println "Goodbye!")
    (recur (inc iteration))))

(re-find #"^left-" "left-eye")


(re-find #"^left-" "cleft-chin")


(re-find #"^left-" "wongleblart")

(matching-part {:name "left-eye" :size 1})


(reduce + [1 2 3 4])

(reduce + 15 [1 2 3 4])

(defn dec-maker
  "decremental maker"
  [decx]
  (fn [x] (- x decx)))

(def dec9 (dec-maker 9))
(dec9 10)

(defn mapset
  [function args]
  (let [x (set args)]
    (map function x)))

(mapset inc [1 1 2 2]) 
; => #{2 3} 
  
