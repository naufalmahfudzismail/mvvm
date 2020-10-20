package id.dev.test.base

abstract class BaseRepository<DataStore> {

    var localDataStore: DataStore? = null
    var remoteDataStore: DataStore? = null

    fun init(localDataStore: DataStore, remoteDataStore: DataStore) {
        this.localDataStore = localDataStore
        this.remoteDataStore = remoteDataStore
    }
}