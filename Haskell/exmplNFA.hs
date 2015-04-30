import NFA 

data Q = Q0 | Q1 | Q2 | Q3 | Q4 
    deriving (Show,Eq,Ord)
data Sigma = O | I | T
    deriving (Show,Ord,Eq)


final :: [Q] -> Bool
final list = or [elem Q0 list,elem Q3 list]

delta :: Sigma -> Q -> [Q]
delta O Q0 = [Q0]
delta I Q0 = [Q1,Q0]
delta T Q0 = [Q4]

delta I Q1 = [Q2]
delta _ Q1 = []

delta I Q2 = [Q3]
delta _ Q2 = []

delta _ Q3 = [Q3]

delta O Q4 = [Q4]
delta I Q4 = [Q4,Q1]
delta T Q4 = [Q0]


w1 = [O,O,O]
w2 = [O,T,O,T,T]
w3 = [O,I,I,O,T,T]
w4 = [O,I,I,I,T]
w5 = [O,I,I,T,I,I,O,O]
w6 = [T,O,O,I,I,I,O,T]
w7 = [I,O,O,I,T]
ws = [w1,w2,w3,w4,w5,w6,w7]
r = runNFA ([Q0],delta,final)

main = do return $ map r ws
