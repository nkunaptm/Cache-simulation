# Cache-simulation
implement a multilevel direct-mapped cache that supports a read operation for a fictional machine with a 16-bit address space. The cache should be configurable to support any number of blocks (you may assume this is a power of 2) and any block size (again, you may assume this is a power of 2). These configuration options can either be passed into your application at run time as command-line arguments or specified as constants in your application. Your simulator must take at least a one command-line argument: the memory test set for the simulator to use. For example:  python my_cache_simulator.py mem_test.addr