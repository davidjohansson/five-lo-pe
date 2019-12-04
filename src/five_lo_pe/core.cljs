(ns five-lo-pe.core
  (:require
    [reagent.core :as reagent]
    [re-com.core :refer [button label progress-bar box v-box h-box]]
    ))

(enable-console-print!)

(def data {:team {
                  :name    "5 med lotta och peter"
                  :periods [
                            {
                             :start                    "2019-01-01"
                             :end                      "2019-09-01"
                             :requiredDaysInPeriodPart 5
                             :parts                    [
                                                        {
                                                         :start   "2019-01-01"
                                                         :end     "2019-01-07"
                                                         :results [{
                                                                    :name       "Peter"
                                                                    :activities '(
                                                                                  {
                                                                                   :date "2019-01-01"
                                                                                   :note "Löpning 8 km"
                                                                                   })
                                                                    }
                                                                   {
                                                                    :name       "Lotta"
                                                                    :activities '(
                                                                                  {
                                                                                   :date "2019-01-01"
                                                                                   :note "Löpning 8 km"
                                                                                   })
                                                                    }
                                                                   {
                                                                    :name       "David"
                                                                    :activities '(
                                                                                  {
                                                                                   :date "2019-01-01"
                                                                                   :note "Löpning 8 km"
                                                                                   })
                                                                    }
                                                                   ]
                                                         }
                                                        ]
                             }
                            ]
                  }
           }
  )

(defn progressInPercent [doneInPeriodPart periodPartLength]
  (* 100 (/ doneInPeriodPart periodPartLength))
  )

(defn statusFromProgress [progress]
  (if (< progress 25)
    "pbar-not-ok"
    (if (< progress 50)
      "pbar-so-so"
      "pbar-ok"
      )
    )
  )

(defn personScore [name doneInPeriodPart periodPartLength]
  (def progress (progressInPercent doneInPeriodPart periodPartLength))
  [h-box :width "200px" :justify :around
   :children [name
              [progress-bar :model progress :style {:width "150px"} :bar-class (statusFromProgress progress)]
              ]])

(defn score []
  (println {:team data})
  [:ul
   [:li [personScore "Peter" 1 5]]
   [:li [personScore "Lotta" 2 5]]
   [:li [personScore "David" 5 5]]]
  )

(defn hello-world []
  [v-box
   :align :center
   :children [
              [box :child [:h1 "5 med Lotta och Peter"]]
              [h-box
               :height "100px"
               :children [
                          [box :size "1200px" :child [score]]
                          ]
               ]
              ]
   ]
  )

(reagent/render-component [hello-world]
                          (. js/document (getElementById "app")))

(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
  )
