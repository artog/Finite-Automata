module ENFA where
import Data.List as List


deltaHat :: Eq q 
    => (q -> [q]) 
    -> (s -> q -> [q]) 
    -> [s] 
    -> [q] 
    -> [q]
deltaHat eclose d [] qs = nub $ concat $ map eclose qs
deltaHat eclose d (a:xs) qs = deltaHat eclose d xs nextStates
    where 
        nextStates = nub $ concat $ map (d a) qs


runENFA :: Eq q => ([q],(s -> q -> [q]),([q] -> Bool),(q -> [q])) -> [s] -> Bool
runENFA (q0,d,f,eclose) word = f finalState 
    where 
        finalState = deltaHat eclose d word ecQ0
        ecQ0 = deltaHat eclose d [] q0







