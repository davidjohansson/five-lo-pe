(ns five_lo_pe.tests
  (:require [cljs.test :refer-macros [deftest is testing run-tests]]))


(deftest addition
  (is (= 4 (+ 2 2)))
  (is (= 7 (+ 3 4))))