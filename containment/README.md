# containment

A pallet project for provisioning graph servers that are nodes in a graph of servers.

## Usage

Use to build server deps. This package assumes you have at least set up
1. Passwordless ssh using rsa public key.
2. Passwordless sudoing for your user.
3. node is secure! (not using root, firewalled, etc.) 

## Security Warning

Do not put security configuration scripts here. Security related config should be done incrementally and by hand--if you aren't
typing a script someone else could be modifying it before runtime! 
This project is meant for use after a server has been completely secured and firewalled.

## License

Copyright ©  FIXME

Distributed under the Eclipse Public License.
