module eNFA where
import Data.List as List


deltaHat :: Eq q => (Maybe s -> q -> [q]) -> [s] -> [q] -> [q]
deltaHat d [] qs = qs
deltaHat d (a:xs) qs = deltaHat d xs nextStates
    where 
        eclose = deltaHat d [Nothing] qs
        nextStates = nub $ concat $ map (d a) eclose


runNFA :: Eq q => ([q],(s -> q -> [q]),([q] -> Bool)) -> [s] -> Bool
runNFA (q0,d,f) word = f finalState 
    where finalState = deltaHat d word q0







