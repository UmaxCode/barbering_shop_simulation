# Barbering Shop Simulation (Java) 

This is a barbering shop simulation where the owner has two types of chairs for hair trimming:
- Main chair (1 chair which is the first chair)
- Waiting chair (5 chairs) 

In Total there are only 6 chairs in the shop. The owner of the shop has two types of clients:
- VIP (special customers)
- ORD (ordinary customers)

To keep track of the type of customers and their seating arrangement, the owner uses an
indexing system. The ordinary customer is labelled ORD1 , ORD2 , ORD3 , etc. In a similar way
special customers are labelled VIP1 , VIP2 , VIP3 , etc.

### The seating and movement of customers in the salon follows these rules:
- When a client comes in, and both **main** and **waiting** chairs are empty, he sits in the **main**
   chair to have his hair trimmed. 
- Any other client who comes into the shop while the **main** chair is occupied, will sit in the
   **waiting** chairs according to their arrival order. A client sits only if there is an available chair,
   otherwise he/she will have to leave the shop and come back later, regardless of their type
   ( **ORD** or **VIP** ) . 
- When a **VIP** comes into the shop while and the **main** chair is occupied and there is an
   available **waiting** chair, he sits in the **first waiting** chair so that he/she can be the next to sit in
   the **main** chair. If there was an **ORD** client in the **first waiting** chair, that **ORD** client has to
   move to the next seat making everyone in the queue to shift backward by one seat. 
- If a **VIP** is already in the queue, the next **VIP** who arrives will take seat after the **last VIP** . 
- When the barber is done with the client in the **main** chair, the next seated in **chair No. 1** takes
   his place and the rest of the clients shift successively to occupy the next chairs and leave the
   empty chair behind them. 
- When clients have their hair trimmed, they leave and do not come back to the shop again.

### To determine whether a client is serviced or not when he/she enters the shop
A random number (0 - 3 inclusive) is generated say **x**:
- If **x = 0** : the event is ( -- clientName ), meaning the barber is done trimming the hair
  of the current client ( ORDi or VIPi where i = 1, 2, 3 ...) seated in the main chair.
- If **x = 1** : the event is ( ++ VIPi ) meaning a **VIP** number 'i' has come into the shop and is
  seated.
- If **x = 2 or x = 3** : the event is ( ++ ORDi ) meaning an **ORD** number 'i' has
  come into the shop and is seated.
- If all the seats are occupied and **x > 0**, the event is ( +- clientName ) meaning the
  client has come and is gone back.
  upon a new simulation, the program will display a new line following this format:
  x ---> ( event ) [ sitting order of clients in the shop ]

*Eg. 1 ---> ( ++ VIP1 ) [ VIP1 : ---- : ---- : ---- : ---- : ----]*

**NOTE :**
The program asks from a keyword input
- if the user enters the **space key**, the program will generate the random number and proceed with execution
- if the user enters any other key different from the space key, the program quits.

# THANK YOU


