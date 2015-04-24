module DFA where

deltaHat :: (q -> s -> q) -> [s] -> q -> q
deltaHat d []     q = q
deltaHat d (a:xs) q = deltaHat d xs $ d q a 


run :: a -> (a -> b -> a) -> (a -> Bool) -> [b] -> Bool
run q0 d f word = f (deltaHat d word q0)

