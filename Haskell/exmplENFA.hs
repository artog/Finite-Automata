import ENFA 

data Q = Q0 | Q1 | Q2 | Q3 | Q4
    deriving (Show,Eq,Ord)
data Sigma = P | M | D | I | O
    deriving (Show,Ord,Eq)


final :: [Q] -> Bool
final list = elem Q4 list

delta :: Sigma -> Q -> [Q]
delta P Q0 = [Q1]
delta M Q0 = [Q1]
delta _ Q0 = []
delta O Q1 = [Q2]
delta I Q1 = [Q1]
delta _ Q1 = []
delta D Q2 = [Q3]
delta I Q2 = [Q2]
delta O Q2 = [Q2]
delta _ Q2 = []
delta I Q3 = [Q4]
delta O Q3 = [Q4]
delta I Q4 = [Q4]
delta O Q4 = [Q4]
delta _ Q4 = []

eclose :: Q -> [Q]
eclose Q0 = [Q0,Q1]
eclose Q1 = [Q1]
eclose Q2 = [Q2,Q4]
eclose Q3 = [Q3]
eclose Q4 = [Q4]


w1 = [O,O,O]
w2 = [P,O,D,I]
w3 = [M,O,I,O,O]
w4 = [P,M,O,O,O,O]
w5 = [O,D,I,I,I,I,I]
w6 = [I,P,O,O,O,O,O,O]
ws = [w1,w2,w3,w4,w5,w6]
r = runENFA ([Q0],delta,final,eclose)

main = do return $ map r ws
