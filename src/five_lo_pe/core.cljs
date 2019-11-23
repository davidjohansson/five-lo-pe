(ns hello-world.core
  (:require
    [reagent.core :as reagent]
    [re-com.core :refer [button label progress-bar box v-box h-box]]
    ))

(enable-console-print!)

(defn statusFromProgress [progress]
  (if (< progress 25)
    "pbar-not-ok"
    (if (< progress 50)
      "pbar-so-so"
      "pbar-ok"
      )
    )
  )

(defn personScore [name progress]

  [h-box :width "200px" :justify :around
   :children [name
              [progress-bar :model progress :style {:width "150px"} :bar-class (statusFromProgress progress)]
              ]])

(defn score []
  [:ul
   [:li [personScore "Peter" 33]]
   [:li [personScore "Lotta" 68]]
   [:li [personScore "David" 12]]]
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
