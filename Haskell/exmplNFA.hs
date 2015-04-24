import NFA 

data Q = Q0 | Q1 | Q2 | Q3 | Q4 | Q5 | Q6 | Q7 | Q8
    deriving (Show,Eq,Ord)
data Sigma = O -- | I
    deriving (Show,Ord,Eq)


final :: [Q] -> Bool
final list = or [elem Q0 list,elem Q3 list,elem Q8 list]

delta :: Sigma -> Q -> [Q]
delta O Q0 = [Q1,Q4]
delta O Q1 = [Q2]
delta O Q2 = [Q3]
delta O Q3 = [Q1]
delta O Q4 = [Q5]
delta O Q5 = [Q6]
delta O Q6 = [Q7]
delta O Q7 = [Q8]
delta O Q8 = [Q4]


w1 = [O,O,O]
w2 = [O,O,O,O]
w3 = [O,O,O,O,O]
w4 = [O,O,O,O,O,O]
w5 = [O,O,O,O,O,O,O]
w6 = [O,O,O,O,O,O,O,O]
ws = [take n (repeat O) | n <- [1..10]]
r = runNFA ([Q0],delta,final)

main = do return $ map r ws
