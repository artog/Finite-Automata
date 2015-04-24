import DFA

data Q = Q0 | Q1 | Q2
    deriving (Show)
data Sigma = O | I
    deriving Show


final :: Q -> Bool
final Q2 = True
final _  = False

delta :: Q -> Sigma -> Q
delta Q0 O = Q0
delta Q0 I = Q1
delta Q1 O = Q2
delta Q1 I = Q1
delta Q2 O = Q2
delta Q2 I = Q2



w1 = [I,I,I,I,I,I,I,I]
w2 = [I,I,I,O,O,I,I,I]
w3 = [I,I,I,O,O,O,O,O]
w4 = [O,O,O,O,O,I,I,I]
w5 = [O,O,O,O,O,O,O,O]

r = run Q0 delta final
