(ns signal-station.signal
  (:use-macros
   [dommy.macros :only [sel sel1 node]]
   [cljs.core.async.macros :only [go]])
  (:require
   [cljs.core.async :as async :refer [<! >! chan close! sliding-buffer put! alts!]]
   [dommy.utils :as utils]
   [dommy.core :as dommy]
   [shoreleave.remotes.http-rpc :refer [remote-callback]]))

(defn render-templates [state]
      (dommy.append! (sel1 :#signup)
                     (node
                      [:div
                       [:input#email-value
                        [:button.btn-success {:text state}]]])))

(defn click-chan [handling-selector value-selector msg-name]
  (let [rc (chan)
        value (atom "")]
    (dommy/listen! ((sel1 handling-selector)
                         :click (fn [e] (swap! value (sel1 value-selector)))))
    (put! rc [msg-name value])
    rc))

(defn save-email! [email]
  (remote-callback :beta-signup [email]
                   %))

(defn app-loop [start-state]
  (let [new-email-click (click-chan :.btn-success :#email-value :new-email)]
    (go
     (loop [state start-state]
       (render-templates state)
       (swap! state  (save-email! (<! new-email-click)))
       (render-templates state)))))

(defn ^:export init []
  (app-loop "Sign up for the beta."))
