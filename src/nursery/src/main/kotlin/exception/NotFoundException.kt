package exception

class NotFoundException(itemKey: String) : BaseException("exception.not.found", itemKey)
