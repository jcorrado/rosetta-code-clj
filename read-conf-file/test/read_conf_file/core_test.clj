(ns read-conf-file.core-test
  (:require [clojure.test :refer :all]
            [read-conf-file.core :refer :all]
            [clojure.java.io :as io]))

(deftest test-parse-line
  (testing "token, no value"
    (is (= ["foo" [true]]
           (parse-line "foo"))))

  (testing "token, single value"
    (is (= ["foo" ["bar"]]
           (parse-line "foo bar"))))

  (testing "token, single value, case normalized"
    (is (= ["foo" ["BAR"]]
           (parse-line "FOO BAR"))))

  (testing "token, single value, equal sep"
    (is (= ["foo" ["bar"]]
           (parse-line "foo=bar"))))

  (testing "token, single value with whitespace"
    (is (= ["foo" ["bar baz"]]
           (parse-line "foo bar baz"))))

  (testing "token, multiple values, comma separated"
    (is (= ["foo" ["bar" "baz"]]
           (parse-line "foo bar, baz"))))

  (testing "token, multiple values with whitespace, comma separated"
    (is (= ["foo" ["bar baz" "quux fizz"]]
           (parse-line "foo bar baz, quux fizz")))))

(deftest test-mk-conf
  (let [good-conf {"fullname" ["Foo Barber"],
                   "favouritefruit" ["banana"],
                   "needspeeling" [true],
                   "otherfamily" ["Rhu Barber" "Harry Barber"]}]
    (is (= good-conf
           (-> (io/resource "config.txt")
               get-lines 
               mk-conf)))))
