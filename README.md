# Cache-simulation
implementation of a multilevel direct-mapped cache that supports a read operation for a fictional machine with a 16-bit address space. The cache is configurable to support any number of blocks (you may assume this is a power of 2) and any block size (again, you may assume this is a power of 2). These configuration options can either be passed into the application at run time as command-line arguments or specified as constants in the application. the simulator can takes command-line arguments: the memory test set for the simulator to use. For example:  python my_cache_simulator.py mem_test.addr
