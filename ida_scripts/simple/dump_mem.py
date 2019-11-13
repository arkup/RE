import idautils 
import idaapi

def memdump(ea, size, file):
    data = get_bytes(ea, size)
    with open(file, "wb") as fp:
        fp.write(data)
        print("Memdump Success!")

# ea  = ida_kernwin.get_screen_ea()
#begin_addr_str = ida_kernwin.ask_str("Default value", 0, "Please enter string")
#begin_addr = int(begin_addr_str,16)

beginEA = 0x0
endEA = 0x10

i = endEA-beginEA
print ("Dumping size: ", i)

memdump(beginEA, i, r"c:\mem_dump.bin")
