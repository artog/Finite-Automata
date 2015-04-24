module NFA where
import Data.List as List


deltaHat :: Eq q => (s -> q -> [q]) -> [s] -> [q] -> [q]
deltaHat d [] qs = qs
deltaHat d (a:xs) qs = deltaHat d xs nextStates
    where 

        nextStates = nub $ concat $ map (d a) qs


runNFA :: Eq q => ([q],(s -> q -> [q]),([q] -> Bool)) -> [s] -> Bool
runNFA (q0,d,f) word = f finalState 
    where finalState = deltaHat d word q0




